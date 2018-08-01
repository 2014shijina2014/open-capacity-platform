initMenu();

function initMenu() {
    $.ajax({
        url: "/permissions/current",
        type: "get",
        async: false,
        success: function (data) {
            if (!$.isArray(data)) {
                location.href = '/login.html';
                return;
            }
            var menu = $("#menu");
            $.each(data, function (i, item) {
                var a = $("<a href='javascript:;'</a>");

                var css = item.css;
                if (css != null && css != "") {
                    a.append("<i  class='fa " + css + "'></i>");
                }
                var span1 = $("<span>" + item.name + "</span>");
                a.append(span1);
                a.attr("lay-id", item.id);

                var href = item.href;
                if (href != null && href != "") {
                    a.attr("href", href);
                    a.attr("iframe-uuid", "uuid-main");
                    a.attr("class", "admin-open-new-tab");

                    a.click(function () {

                        $('#admin-tab-body-index').tabs('open', 0);
                    })
                }

                var li = $("<li></li>");
//	             默认第一项不展开
//	             if (i == 0) {
//	            	 li.addClass("layui-nav-itemed");
//	             }
                li.append(a);

                //二级菜单
                var child2 = item.child;
                if (child2 != null && child2.length > 0) {
                    var dl = $("<ul class='am-list am-collapse admin-sidebar-sub am-in' id='collapse-nav" + item.id + "'></ul>");
                    span1.append("<span class='am-icon-angle-right am-fr am-margin-right'></span>");
                    $.each(child2, function (j, item2) {
                        var ca = $("<a href='javascript:;'></a>");
                        ca.attr("href", item2.href);
                        ca.attr("lay-id", item2.id);


                        li.attr("class", "admin-parent");
                        a.attr("data-am-collapse", "{target: '#collapse-nav" + item.id + "'}")
                        var css2 = item2.css;
                        if (css2 != null && css2 != "") {
                            ca.append("<span class='fa " + css2 + "'></span>");
                        }

                        ca.append("<span>" + item2.name + "</span>");

                        var dd = $("<li></<li>");
                        dd.append(ca);
                        dl.append(dd);


                    });
                    li.append(dl);
                }
                menu.append(li);
            });
        }
    });
}

// 登陆用户头像昵称
showLoginInfo();

function showLoginInfo() {
    $.ajax({
        type: 'get',
        url: '/users/current',
        async: false,
        success: function (data) {
            $(".admin-header-user span").text(data.nickname);

            var pro = window.location.protocol;
            var host = window.location.host;
            var domain = pro + "//" + host;

            var sex = data.sex;
            var url = data.headImgUrl;
            if (url == null || url == "") {
                if (sex == 1) {
                    url = "/img/avatars/sunny.png";
                } else {
                    url = "/img/avatars/1.png";
                }

                url = domain + url;
            } else {
                url = domain + "/statics" + url;
            }
            var img = $(".admin-header-user img");
            img.attr("src", url);
        }
    });
}

function logout() {
    $.ajax({
        type: 'get',
        url: '/logout',
        success: function (data) {
            localStorage.removeItem("token");
            location.href = '/login.html';
        }
    });
}

var active;

layui.use(['layer', 'element'], function () {
    var $ = layui.jquery,
        layer = layui.layer;
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    element.on('nav(demo)', function (elem) {
        //layer.msg(elem.text());
    });

    //触发事件
    active = {
        tabAdd: function (obj) {
            var lay_id = $(this).attr("lay-id");
            var title = $(this).html() + '<i class="layui-icon" data-id="' + lay_id + '"></i>';
            //新增一个Tab项
            element.tabAdd('admin-tab', {
                title: title,
                content: '<iframe src="' + $(this).attr('data-url') + '"></iframe>',
                id: lay_id
            });
            element.tabChange("admin-tab", lay_id);
        },
        tabDelete: function (lay_id) {
            element.tabDelete("admin-tab", lay_id);
        },
        tabChange: function (lay_id) {
            element.tabChange('admin-tab', lay_id);
        }
    };
    //添加tab
    $(document).on('click', 'a', function () {
        if (!$(this)[0].hasAttribute('data-url') || $(this).attr('data-url') === '') {
            return;
        }
        var tabs = $(".layui-tab-title").children();
        var lay_id = $(this).attr("lay-id");

        for (var i = 0; i < tabs.length; i++) {
            if ($(tabs).eq(i).attr("lay-id") == lay_id) {
                active.tabChange(lay_id);
                return;
            }
        }
        active["tabAdd"].call(this);
        resize();
    });

    //iframe自适应
    function resize() {
        var $content = $('.admin-nav-card .layui-tab-content');
        $content.height($(this).height() - 147);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }

    $(window).on('resize', function () {
        var $content = $('.admin-nav-card .layui-tab-content');
        $content.height($(this).height() - 147);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();

    //toggle左侧菜单
    $('.admin-side-toggle').on('click', function () {
        var sideWidth = $('#admin-side').width();
        if (sideWidth === 200) {
            $('#admin-body').animate({
                left: '0'
            });
            $('#admin-footer').animate({
                left: '0'
            });
            $('#admin-side').animate({
                width: '0'
            });
        } else {
            $('#admin-body').animate({
                left: '200px'
            });
            $('#admin-footer').animate({
                left: '200px'
            });
            $('#admin-side').animate({
                width: '200px'
            });
        }
    });

    //手机设备的简单适配
    var treeMobile = $('.site-tree-mobile'),
        shadeMobile = $('.site-mobile-shade');
    treeMobile.on('click', function () {
        $('body').addClass('site-mobile');
    });
    shadeMobile.on('click', function () {
        $('body').removeClass('site-mobile');
    });
});