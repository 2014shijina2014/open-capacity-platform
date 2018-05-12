//treeSelect组件
layui.define('tree', function (exports) {
    "use strict";

    var _MOD = 'treeselect',
        treeData = {}, //全局树形数据缓存
        $ = layui.jquery,
        hint = layui.hint(),
        DISABLED = 'layui-disabled',
        win = $(window),
        TreeSelect = function() {
            this.v = '1.0.0';
        };
    /**
    * 初始化下拉树选择框
    */
    TreeSelect.prototype.render = function (options) {
        var that = this,
            othis =options? $(options.elem):null,
            tips = '请选择',
            CLASS = 'layui-form-select',
            TITLE = 'layui-select-title',
            NONE = 'layui-select-none',
            initValue = '',
            thatInput,
            isString = function(obj) {
                return Object.prototype.toString.call(obj) === "[object String]";
            },
            settext = function (data, val, input) {
                $.each(data,
                    function (_, o) {
                        if (o.id === val) {
                            input.val(o.name);
                            return false;
                        }
                        if (o.children)
                            settext.call(this, o.children, val, input);
                    });
            },
            hide = function(e, clear) {
                if (!$(e.target).parent().hasClass(TITLE) || clear) {
                    $('.' + CLASS).removeClass(CLASS + 'ed ' + CLASS + 'up');
                    thatInput && initValue && thatInput.val(initValue);
                }
                thatInput = null;
            },
            events = function(reElem,treeid, disabled) {
                var title = reElem.find('.' + TITLE),
                    input = title.find('input'),
                    tree = reElem.find('.layui-tree'),
                    o = treeData,
                    defaultVal = othis.val();

                //如果控件有默认值，设置默认值
                if (defaultVal)
                    settext.call(this, o.data, defaultVal, input);

                if (disabled) return;

                //展开下拉
                var showDown = function () {
                        
                    var top = reElem.offset().top + reElem.outerHeight() + 5 - win.scrollTop(),
                        downHeight = win.height() - top - 13,
                        dlHeight = tree.outerHeight();
                        if (downHeight < 300)
                            tree.css("max-height", downHeight + "px");

                        reElem.addClass(CLASS + 'ed');

                        //上下定位识别
                        if (top + dlHeight > win.height() && top >= dlHeight) {
                            reElem.addClass(CLASS + 'up');
                        }
                    },
                    hideDown = function() {
                        reElem.removeClass(CLASS + 'ed ' + CLASS + 'up');
                        input.blur();
                    };

                //点击标题区域
                title.on('click',
                    function(e) {
                        reElem.hasClass(CLASS + 'ed')
                            ? (
                                hideDown()
                            )
                            : (
                                hide(e, true),
                                showDown()
                            );
                        tree.find('.' + NONE).remove();
                    });

                //点击箭头获取焦点
                title.find('.layui-edge').on('click',
                    function() {
                        input.focus();
                    });

                //键盘事件
                input.on('keyup',
                        function(e) {
                            var keyCode = e.keyCode;
                            //Tab键
                            if (keyCode === 9) {
                                showDown();
                            }
                        })
                    .on('keydown',
                        function(e) {
                            var keyCode = e.keyCode;
                            //Tab键
                            if (keyCode === 9) {
                                hideDown();
                            } else if (keyCode === 13) { //回车键
                                e.preventDefault();
                            }
                        });
                //渲染tree
                layui.tree({
                    elem: "#" + treeid,
                    click: function(obj) {
                        othis.val(obj.id).removeClass('layui-form-danger');
                        input.val(obj.name);
                        tree.find(".youyao-this").removeClass("youyao-this");
                        hideDown(true);
                        if (o.selectcall)
                            o.selectcall(obj);
                        return false;
                    },
                    nodes: o.data
                });
                //点击树箭头不隐藏
                tree.find(".layui-tree-spread").on('click',
                    function() {
                        return false;
                    });
                //关闭下拉
                $(document).off('click', hide).on('click', hide);
            },
            init = function(treeid) {
                var hasRender = othis.next('.' + CLASS),
                    disabled = othis[0].disabled,
                    value = othis.value,
                    placeholder = othis.attr("placeholder") ? othis.attr("placeholder") : tips;
                if (typeof othis.attr('lay-ignore') === 'string') return othis.show();
                //隐藏原控件
                othis.hide();
                othis.addClass("layui-input-treeselect");
                othis.attr("data-treeid", treeid);
                //替代元素
                var reElem = $([
                    '<div class="layui-unselect ' + CLASS + (disabled ? ' layui-select-disabled' : '') + '">',
                    '<div class="' +
                    TITLE +
                    '"><input type="text" placeholder="' +
                    placeholder +
                    '" id="' +
                    treeid +
                    "_text" +
                    '" value="' +
                    (value ? selected.html() : '') +
                    '" readonly class="layui-input layui-unselect' +
                    (disabled ? (' ' + DISABLED) : '') +
                    '">', '<i class="layui-edge"></i></div>',
                    '<ul id="' + treeid + '" class="layui-anim layui-anim-upbit layui-tree"></ul>', '</div>'
                ].join(''));
                hasRender[0] && hasRender.remove(); //如果已经渲染，则Rerender
                othis.after(reElem);
                events.call(this, reElem, treeid, disabled);
            },
            reset = function(filter) {
                var trees = filter ? $('*[lay-filter="' + filter + '"]') : $(".layui-input-treeselect");
                layui.each(trees,
                    function (_, one) {
                        othis = $(one);
                        var treeid = othis.attr("data-treeid");
                        init.call(this, treeid);
                    });
            };
        if (!options)
            return reset.call(this,null);
        if (options.filter)
            return reset.call(this,options.filter);
        if (!othis[0])
            return hint.error('layui.treeSelect 没有找到' + options.elem + '元素');
        if (!options.data)
            return hint.error(
                'layui.treeSelect 缺少参数 data ,data 可直接指定treedata，也可以是treedata数据url，treedata参见layui tree模块');
        var treeid = "selecttree_" + options.elem.replace("#", "");
        if (!isString.call(this, options.data)) {
            //缓存tree data
            treeData = options;
            init.call(this, treeid);
        } else {
            $.ajax({
                url: options.data,
                dataType: "json",
                type: !options.method ? "POST" : options.method,
                success: function(d) {
                    options.data = d;
                    treeData = options;
                    init.call(this, treeid);
                }
            });
        }
    };
    var treeSelect = new TreeSelect();
    //暴露接口
    exports(_MOD, treeSelect);
	layui.link(layui.cache.base + 'css/treeSelect.css', null, 'treeSelectcss');
});
