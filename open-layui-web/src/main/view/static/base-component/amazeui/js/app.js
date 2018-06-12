(function($) {
  'use strict';

  $(function() {
    var $fullText = $('.admin-fullText');
    $('#admin-fullscreen').on('click', function() {
      $.AMUI.fullscreen.toggle();
    });

    $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
      $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
    });
  });
})(jQuery);


/*全局配置tab控制*/
$(function() {
  var tabCounter = 0;
  var $tab = $('#admin-tab-body-index');
  var $nav = $tab.find('.am-tabs-nav');
  var $bd = $tab.find('.am-tabs-bd');

  function addTab() {
    var nav = '<li><span class="am-icon-close"></span>' +
        '<a href="javascript: void(0)">标签 ' + tabCounter + '</a></li>';
    var content = '<div class="am-tab-panel">动态插入的标签内容' + tabCounter + '</div>';

    $nav.append(nav);
    $bd.append(content);
    tabCounter++;
    $tab.tabs('refresh');
  }

  // 动态添加标签页
  $('.js-append-tab').on('click', function() {
    addTab();
  });

  /**
   * 动态添加tab
   */
  $(document).on('click','.admin-open-new-tab',function(){
    var iframeUrl = $(this).attr('iframe-url');
    var iframeName = $(this).attr('iframe-name');
    var iframeUuid = $(this).attr('iframe-uuid');
    if(!iframeUrl || !iframeUuid){
      return;
    }
    addIframeTal(iframeUrl,iframeName,iframeUuid);
  });

  /**
   * 刷新当前tab页面
   */
  $(document).on('click','.am-tab-refresh',function(){
    var clickIndex = 0;
    var iframeUuid = $(this).attr('iframe-uuid');
    $('#admin-tab-body-index>ul>li').each(function(index){
      if($(this).attr('iframe-uuid') == iframeUuid){
        clickIndex = index;
        return;
      }
    });
    //console.log($($('#admin-tab-body-index .am-tabs-bd .am-tab-panel')[clickIndex]).find('iframe')[0])
    $('.admin-iframe-html')[clickIndex].contentWindow.location.reload(true);
  });


  function addIframeTal(iframeUrl,tabName,iframeUuid){
    var haveFlg = false;
    //判断是否打开了该标签页，不能重复打开标签页
    $('#admin-tab-body-index>ul>li').each(function(index){
      if($(this).attr('iframe-uuid') == iframeUuid){
        $tab.tabs('open',index);
        haveFlg = true;
        return;
      }
    });
    if(haveFlg == true){
      return;
    }

    //不存在该tab则新建tab
    var nav = '<li iframe-uuid="'+iframeUuid+'">' +
        '<span class="am-tab-refresh am-icon-refresh" iframe-url="'+iframeUrl+'" iframe-uuid="'+iframeUuid+'"></span>' +
        '<span class="am-icon-close"></span>' +
        '<a href="javascript: void(0)" iframe-uuid="'+iframeUuid+'">' + tabName + '</a></li>';
    var content = '<div class="am-tab-panel" style="height: 100%"><iframe src="'+iframeUrl+'" class="admin-iframe-html" style="width: 100%;height: 100%;"></iframe></div>';
    $nav.append(nav);
    $bd.append(content);
    $tab.tabs('refresh');
    //$('#admin-tab-body-index').tabs('open',$('#admin-tab-body-index>ul>li').length -1);
    setTimeout("$('#admin-tab-body-index').tabs('open',$('#admin-tab-body-index>ul>li').length -1);",50);
  }



  // 移除标签页
  $nav.on('click', '.am-icon-close', function() {
    var $item = $(this).closest('li');
    var index = $nav.children('li').index($item);

    $item.remove();
    $bd.find('.am-tab-panel').eq(index).remove();

    $tab.tabs('open', index > 0 ? index - 1 : index + 1);
    $tab.tabs('refresh');
  });

  /**
   * 左移tab标签
   */
  $('.admin-tab-left').on('click',function(){
    moveToRight();
  });

  function moveToLeft(){
    //需要显示的下一个tab
    var getCurrentFlg = false;
    var currentTab = 0;
    //需要添加的margin-left总数
    var addMargin = 0;
    var tabLength = $('.admin-tab-show').width();
    var allTabLength = 0;
    var oneMarginLeft = parseInt($($('#admin-tab-body-index>ul>li')[0]).css('margin-left'));
    $('#admin-tab-body-index>ul>li').each(function(index){
      allTabLength = allTabLength + $(this).width();
      if(parseInt($(this).css('margin-left')) == 0 && getCurrentFlg == false){
        currentTab = index;
        getCurrentFlg = true;
      }
    });
    if((allTabLength + oneMarginLeft)> tabLength){
      /*$('#admin-tab-body-index>ul>li').css('margin-left',(oneMarginLeft-100)+'px')*/
      for(var i=0;i<$('#admin-tab-body-index>ul>li').length;i++){
        if(i == currentTab+1){
          break;
        }
        if(i==currentTab){
          addMargin = parseInt($($('#admin-tab-body-index>ul>li')[i]).css('margin-left')) - $($('#admin-tab-body-index>ul>li')[currentTab]).width() -20;
        }else{
          addMargin = parseInt($($('#admin-tab-body-index>ul>li')[i]).css('margin-left')) - $($('#admin-tab-body-index>ul>li')[currentTab]).width();
        }
        //$($('#admin-tab-body-index>ul>li')[i]).animate({'margin-left':addMargin+'px'},"fast");
        $($('#admin-tab-body-index>ul>li')[i]).css('margin-left',addMargin+'px');
      }
    }
  }
  /**
   * 右移tab标签
   */
  $('.admin-tab-right').on('click',function(){
    moveToLeft();
  });

  function moveToRight(){
//需要显示的下一个tab
    var getCurrentFlg = false;
    var currentTab = 0;
    //需要添加的margin-left总数
    var addMargin = 0;
    var tabLength = $('.admin-tab-show').width();
    var allTabLength = 0;
    var oneMarginLeft = parseInt($($('#admin-tab-body-index>ul>li')[0]).css('margin-left'));
    $('#admin-tab-body-index>ul>li').each(function(index){
      allTabLength = allTabLength + $(this).width();
      if(parseInt($(this).css('margin-left')) == 0 && getCurrentFlg == false){
        currentTab = index;
        getCurrentFlg = true;
      }
    });
    if(currentTab != 0){
      for(var i=0;i<$('#admin-tab-body-index>ul>li').length;i++){
        if(parseInt($($('#admin-tab-body-index>ul>li')[i]).css('margin-left')) !=0){
          if((currentTab - 1) == i ){
            addMargin = parseInt($($('#admin-tab-body-index>ul>li')[i]).css('margin-left')) + $($('#admin-tab-body-index>ul>li')[currentTab-1]).width()+20;
          }else{
            addMargin = parseInt($($('#admin-tab-body-index>ul>li')[i]).css('margin-left')) + $($('#admin-tab-body-index>ul>li')[currentTab-1]).width();
          }
          //$($('#admin-tab-body-index>ul>li')[i]).animate({'margin-left':addMargin+'px'},"fast");
          $($('#admin-tab-body-index>ul>li')[i]).css('margin-left',addMargin+'px');
        }
      }
    }
  }

  $('.admin-tab-right-close-all').on('click', function () {
    if($('.am-icon-close').length == 0){
      return;
    }
    layer.confirm('是否确定删除其他TAB选项卡', {icon: 3,skin: 'layer-ext-moon', title: '提示'}, function (index) {
      //do something
      $('.am-icon-close').each(function(index){
        var $item = $(this).closest('li');
        var index = $nav.children('li').index($item);
        $item.remove();
        $bd.find('.am-tab-panel').eq(index).remove();
      });
      $tab.tabs('open', 0);
      $tab.tabs('refresh');
      layer.close(index);
    });
  });
});

/**
 * 页面执行完加载左侧列表
 */
(function () {
  var html = '';
  var mainClick = "$('#admin-tab-body-index').tabs('open', 0);";
  html = html + '<li><a href="javascript:void(0);" iframe-uuid="' + TAB_JSON.list[0].listUuid + '" onclick="' + mainClick + '" class="admin-open-new-tab">' +
      '<span class="' + TAB_JSON.list[0].listIcon + '"></span> ' + TAB_JSON.list[0].listName + ' ' +
      '<span class="' + TAB_JSON.list[0].listRightIcon + ' am-fr am-margin-right ' + TAB_JSON.list[0].listNumberColor + '">' +
      '' + TAB_JSON.list[0].listNumber + '</span></a></li>';
  for (var i = 1; i < TAB_JSON.list.length; i++) {
    if (TAB_JSON.list[i].isHtml == true) {
      html = html + '<li><a href="javascript:void(0);" iframe-uuid="' + TAB_JSON.list[i].listUuid + '" class="admin-open-new-tab">' +
          '<span class="' + TAB_JSON.list[i].listIcon + '"></span> ' + TAB_JSON.list[i].listName + ' ' +
          '<span class="' + TAB_JSON.list[i].listRightIcon + ' am-fr am-margin-right ' + TAB_JSON.list[i].listNumberColor + '">' +
          '' + TAB_JSON.list[i].listNumber + '</span></a></li>';
    } else {
      var subListIdName = 'collapse' + i;
      var subListId = "{target: '#" + subListIdName + "'}";
      html = html + '<li class="admin-parent">' +
          '<a class="am-cf am-collapsed" data-am-collapse="' + subListId + '"><span class="' + TAB_JSON.list[i].listIcon + '">' +
          '</span> ' + TAB_JSON.list[i].listName + ' <span class="' + TAB_JSON.list[i].listRightIcon + ' am-fr am-margin-right"></span></a>';
      if (TAB_JSON.list[i].subList.length == 0) {
        html = html + '</li>';
        break;
      } else {
        html = html + '<ul class="am-list admin-sidebar-sub am-collapse" id="' + subListIdName + '">';
        for (var j = 0; j < TAB_JSON.list[i].subList.length; j++) {
          html = html + ' <li><a href="javascript:void(0);" iframe-url="' + TAB_JSON.list[i].subList[j].listUrl + '" ' +
              'iframe-name="' + TAB_JSON.list[i].subList[j].listName + '" iframe-uuid="' + TAB_JSON.list[i].subList[j].listUuid + '" class="am-cf admin-open-new-tab">' +
              '<span class="' + TAB_JSON.list[i].subList[j].listIcon + '"></span> ' + TAB_JSON.list[i].subList[j].listName + '' +
              '<span class="' + TAB_JSON.list[i].subList[j].listRightIcon + ' am-fr am-margin-right ' + TAB_JSON.list[i].subList[j].listNumberColor + '">' +
              '' + TAB_JSON.list[i].subList[j].listNumber + '</span>' +
              '</a></li>'
        }
        html = html + '</ul> </li>';
      }
    }
  }

  $('#admin-list-config').html(html);
})();

