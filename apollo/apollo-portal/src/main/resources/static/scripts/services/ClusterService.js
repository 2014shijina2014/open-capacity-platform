appService.service('ClusterService', ['$resource', '$q', function ($resource, $q) {
    var cluster_resource = $resource('', {}, {
        create_cluster: {
            method: 'POST',
            url: 'apps/:appId/envs/:env/clusters'
        }
    });
    return {
        create_cluster: function (appId, env, cluster) {
            var d = $q.defer();
            cluster_resource.create_cluster({
                                                appId: appId,
                                                env: env
                                            }, cluster,
                                            function (result) {
                                                d.resolve(result);
                                            }, function (result) {
                    d.reject(result);
                });
            return d.promise;
        }
    }
}]);
