role_module.controller('NamespaceRoleController',
                       ['$scope', '$location', '$window', 'toastr', 'AppService', 'UserService', 'AppUtil',
                        'PermissionService',
                        function ($scope, $location, $window, toastr, AppService, UserService, AppUtil,
                                  PermissionService) {

                            var params = AppUtil.parseParams($location.$$url);
                            $scope.pageContext = {
                                appId: params.appid,
                                namespaceName: params.namespaceName
                            };

                            $scope.modifyRoleSubmitBtnDisabled = false;
                            $scope.ReleaseRoleSubmitBtnDisabled = false;

                            $scope.releaseRoleWidgetId = 'releaseRoleWidgetId';
                            $scope.modifyRoleWidgetId = 'modifyRoleWidgetId';

                            PermissionService.has_assign_user_permission($scope.pageContext.appId)
                                .then(function (result) {
                                    $scope.hasAssignUserPermission = result.hasPermission;
                                }, function (reslt) {

                                });

                            PermissionService.get_namespace_role_users($scope.pageContext.appId,
                                                                       $scope.pageContext.namespaceName)
                                .then(function (result) {
                                    $scope.rolesAssignedUsers = result;
                                }, function (result) {
                                    toastr.error(AppUtil.errorMsg(result), "加载授权用户出错");
                                });

                            $scope.assignRoleToUser = function (roleType) {
                                if ('ReleaseNamespace' == roleType) {
                                    var user = $('.' + $scope.releaseRoleWidgetId).select2('data')[0];
                                    if (!user) {
                                        toastr.warning("请选择用户");
                                        return;
                                    }
                                    $scope.ReleaseRoleSubmitBtnDisabled = true;
                                    var toAssignReleaseNamespaceRoleUser = user.id;
                                    PermissionService.assign_release_namespace_role($scope.pageContext.appId,
                                                                                    $scope.pageContext.namespaceName,
                                                                                    toAssignReleaseNamespaceRoleUser)
                                        .then(function (result) {
                                            toastr.success("添加成功");
                                            $scope.ReleaseRoleSubmitBtnDisabled = false;
                                            $scope.rolesAssignedUsers.releaseRoleUsers.push(
                                                {userId: toAssignReleaseNamespaceRoleUser});
                                            $('.' + $scope.releaseRoleWidgetId).select2("val", "");
                                        }, function (result) {
                                            $scope.ReleaseRoleSubmitBtnDisabled = false;
                                            toastr.error(AppUtil.errorMsg(result), "添加失败");
                                        });
                                } else {
                                    var user = $('.' + $scope.modifyRoleWidgetId).select2('data')[0];
                                    if (!user) {
                                        toastr.warning("请选择用户");
                                        return;
                                    }
                                    $scope.modifyRoleSubmitBtnDisabled = true;
                                    var toAssignModifyNamespaceRoleUser = user.id;
                                    PermissionService.assign_modify_namespace_role($scope.pageContext.appId,
                                                                                   $scope.pageContext.namespaceName,
                                                                                   toAssignModifyNamespaceRoleUser)
                                        .then(function (result) {
                                            toastr.success("添加成功");
                                            $scope.modifyRoleSubmitBtnDisabled = false;
                                            $scope.rolesAssignedUsers.modifyRoleUsers.push(
                                                {userId: toAssignModifyNamespaceRoleUser});
                                            $('.' + $scope.modifyRoleWidgetId).select2("val", "");
                                        }, function (result) {
                                            $scope.modifyRoleSubmitBtnDisabled = false;
                                            toastr.error(AppUtil.errorMsg(result), "添加失败");
                                        });
                                }
                            };

                            $scope.removeUserRole = function (roleType, user) {
                                if ('ReleaseNamespace' == roleType) {
                                    PermissionService.remove_release_namespace_role($scope.pageContext.appId,
                                                                                    $scope.pageContext.namespaceName,
                                                                                    user)
                                        .then(function (result) {
                                            toastr.success("删除成功");
                                            removeUserFromList($scope.rolesAssignedUsers.releaseRoleUsers, user);
                                        }, function (result) {
                                            toastr.error(AppUtil.errorMsg(result), "删除失败");
                                        });
                                } else {
                                    PermissionService.remove_modify_namespace_role($scope.pageContext.appId,
                                                                                   $scope.pageContext.namespaceName,
                                                                                   user)
                                        .then(function (result) {
                                            toastr.success("删除成功");
                                            removeUserFromList($scope.rolesAssignedUsers.modifyRoleUsers, user);
                                        }, function (result) {
                                            toastr.error(AppUtil.errorMsg(result), "删除失败");
                                        });
                                }
                            };

                            function removeUserFromList(list, user) {
                                var index = 0;
                                for (var i = 0; i < list.length; i++) {
                                    if (list[i].userId == user) {
                                        index = i;
                                        break;
                                    }
                                }
                                list.splice(index, 1);
                            }

                        }]);
