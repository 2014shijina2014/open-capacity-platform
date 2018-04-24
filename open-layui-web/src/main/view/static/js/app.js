/*****
 * CONFIGURATION
 */

// Active ajax page loader
$.ajaxLoad = true;

//required when $.ajaxLoad = true
//$.defaultPage = "main";
$.subPagesDirectory = '/';
$.page404 = '404';
$.mainContent = $('#ui-view');
$.breadcrumbContent = $('#breadcrumb-view');

//Main navigation
$.navigation = $('nav > ul.nav');

$.panelIconOpened = 'icon-arrow-up';
$.panelIconClosed = 'icon-arrow-down';

//Default colours
$.brandPrimary =  '#20a8d8';
$.brandSuccess =  '#4dbd74';
$.brandInfo =     '#63c2de';
$.brandWarning =  '#f8cb00';
$.brandDanger =   '#f86c6b';

$.grayDark =      '#2a2c36';
$.gray =          '#55595c';
$.grayLight =     '#818a91';
$.grayLighter =   '#d1d4d7';
$.grayLightest =  '#f8f9fa';

'use strict';

/*****
 * ASYNC LOAD
 * Load JS files and CSS files asynchronously in ajax mode
 */
function loadJS(jsFiles, pageScript) {

  var i;
  for(i = 0; i<jsFiles.length;i++){

    var body = document.getElementsByTagName('body')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.async = false;
    script.src = jsFiles[i];
    body.appendChild(script);
  }

  if (pageScript) {
    var body = document.getElementsByTagName('body')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.async = false;
    script.src = pageScript;
    body.appendChild(script);
  }

  init();
}

function loadCSS(cssFile, end, callback) {

  var cssArray = {};

  if (!cssArray[cssFile]) {
    cssArray[cssFile] = true;

    if (end == 1) {

      var head = document.getElementsByTagName('head')[0];
      var s = document.createElement('link');
      s.setAttribute('rel', 'stylesheet');
      s.setAttribute('type', 'text/css');
      s.setAttribute('href', cssFile);

      s.onload = callback;
      head.appendChild(s);

    } else {

      var head = document.getElementsByTagName('head')[0];
      var style = document.getElementById('main-style');

      var s = document.createElement('link');
      s.setAttribute('rel', 'stylesheet');
      s.setAttribute('type', 'text/css');
      s.setAttribute('href', cssFile);

      s.onload = callback;
      head.insertBefore(s, style);

    }

  } else if (callback) {
    callback();
  }

}

/****
 * AJAX LOAD
 * Load pages asynchronously in ajax mode
 */

if ($.ajaxLoad) {

  var paceOptions = {
    elements: false,
    restartOnRequestAfter: false
  };

  var url = location.hash.replace(/^#/, '');

  if (url != '') {
    setUpUrl(url);
  } else if($.indexPage!=''){
    setUpUrl($.indexPage);
  } else {
    setUpUrl($.defaultPage);
  }

  $(document).on('click', 'a[href!="#"]', function(e) {
    if ( $(this).parent().parent().hasClass('nav-tabs') || $(this).parent().parent().hasClass('nav-pills')||$(this).attr('href')=="javascript:;") {
      e.preventDefault();
    } else if ( $(this).attr('target') == '_top' ) {
      e.preventDefault();
      var target = $(e.currentTarget);
      window.location = (target.attr('href'));
    } else if ( $(this).attr('target') == '_blank' ) {
      e.preventDefault();
      var target = $(e.currentTarget);
      window.open(target.attr('href'));
    } else{
      e.preventDefault();
      var target = $(e.currentTarget);
      if(target.attr('href')!=undefined) {
        setUpUrl(target.attr('href'));
      }
    }
  });
}

$(document).on('click', 'a[href="#"]', function(e) {
  e.preventDefault();
});

function setUpUrl(url) {
  if(url.indexOf("@") < 0) {
    $('nav .nav li .nav-link').removeClass('active');
    $('nav .nav li.nav-dropdown').removeClass('open');
    $('nav .nav li:has(a[href="' + url.split('?')[0] + '"])').addClass('open');
    $('nav .nav a[href="' + url.split('?')[0] + '"]').addClass('active');
    loadPage(url);
  }else
  {
    $('nav .nav li .nav-link').removeClass('active');
    $('nav .nav li.nav-dropdown').removeClass('open');
    $('nav .nav li:has(a[href="' + url.split('@')[0].split('?')[0] + '"])').addClass('open');
    $('nav .nav a[href="' + url.split('@')[0].split('?')[0] + '"]').addClass('active');
    loadPage(url.split('@')[1]);
  }


}

function loadPage(url) {
  $.ajax({
    type : 'GET',
    url : $.subPagesDirectory +'api/'+ url,
    dataType : 'json',
    beforeSend: function () {
      $.breadcrumbContent.html("");
      $.mainContent.css({opacity: 0});
    },
    success : function(responseText) {
      //加载面包屑
      for(var index in responseText)
      {
        if(responseText[index].url!== null && typeof(responseText[index].url)!="undefined"){
          if(responseText[index].isleaf=="Y") {
            $.breadcrumbContent.append("<li class='breadcrumb-item active'>"
                + responseText[index].name
                + "</li>");
          }else
          {
            $.breadcrumbContent.append("<li class='nav breadcrumb-item'>"
                + "<a href='" + responseText[index].url + "'>" + responseText[index].name + "</a>"
                + "</li>");
          }
        }else{
          if(responseText[index].isleaf=="Y") {
            $.breadcrumbContent.append("<li class='breadcrumb-item active'>"
                + responseText[index].name
                + "</li>");
          }else
          {
            $.breadcrumbContent.append("<li class='breadcrumb-item'>"
                +responseText[index].name
                +"</li>");
          }

        }
      }
      //加载页面
      $('html, body').animate({scrollTop: 0}, 0);
      $.mainContent.load($.subPagesDirectory + url, null, function (responseText,status,xhr) {
        if(status=="success") {
          window.location.hash=url;
        }else{
          window.location.href = $.page404;
        }
      }).delay(250).animate({opacity: 1}, 0);

    },
    error : function(XMLHttpRequest, textStatus, errorThrown) {
      window.location.href = $.page404;
    }
  });
}

/****
 * MAIN NAVIGATION
 */

$(document).ready(function($){

  // Add class .active to current link - AJAX Mode off
  $.navigation.find('a').each(function(){

    var cUrl = String(window.location).split('?')[0];

    if (cUrl.substr(cUrl.length - 1) == '#') {
      cUrl = cUrl.slice(0,-1);
    }

    if ($($(this))[0].href==cUrl) {
      $(this).addClass('active');

      $(this).parents('ul').add(this).each(function(){
        $(this).parent().addClass('open');
      });
    }
  });

  // Dropdown Menu
  $.navigation.on('click', 'a', function(e){

    if ($.ajaxLoad) {
      e.preventDefault();
    }

    if ($(this).hasClass('nav-dropdown-toggle')) {
      $(this).parent().toggleClass('open');
      resizeBroadcast();
    }
  });

  function resizeBroadcast() {

    var timesRun = 0;
    var interval = setInterval(function(){
      timesRun += 1;
      if(timesRun === 5){
        clearInterval(interval);
      }
      window.dispatchEvent(new Event('resize'));
    }, 62.5);
  }

  /* ---------- Main Menu Open/Close, Min/Full ---------- */
  $('.sidebar-toggler').click(function(){
    $('body').toggleClass('sidebar-hidden');
    resizeBroadcast();
  });

  $('.sidebar-minimizer').click(function(){
    $('body').toggleClass('sidebar-minimized');
    resizeBroadcast();
  });

  $('.brand-minimizer').click(function(){
    $('body').toggleClass('brand-minimized');
  });

  $('.aside-menu-toggler').click(function(){
    $('body').toggleClass('aside-menu-hidden');
    resizeBroadcast();
  });

  $('.mobile-sidebar-toggler').click(function(){
    $('body').toggleClass('sidebar-mobile-show');
    resizeBroadcast();
  });

  $('.sidebar-close').click(function(){
    $('body').toggleClass('sidebar-opened').parent().toggleClass('sidebar-opened');
  });

  /* ---------- Disable moving to top ---------- */
  $('a[href="#"][data-top!=true]').click(function(e){
    e.preventDefault();
  });

});

/****
 * CARDS ACTIONS
 */

$(document).on('click', '.card-actions a', function(e){
  e.preventDefault();

  if ($(this).hasClass('btn-close')) {
    $(this).parent().parent().parent().fadeOut();
  } else if ($(this).hasClass('btn-minimize')) {
    var $target = $(this).parent().parent().next('.card-body');
    if (!$(this).hasClass('collapsed')) {
      $('i',$(this)).removeClass($.panelIconOpened).addClass($.panelIconClosed);
    } else {
      $('i',$(this)).removeClass($.panelIconClosed).addClass($.panelIconOpened);
    }

  } else if ($(this).hasClass('btn-setting')) {
    $('#myModal').modal('show');
  }

});

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}

function init(url) {

  /* ---------- Tooltip ---------- */
  $('[rel="tooltip"],[data-rel="tooltip"]').tooltip({"placement":"bottom",delay: { show: 400, hide: 200 }});

  /* ---------- Popover ---------- */
  $('[rel="popover"],[data-rel="popover"],[data-toggle="popover"]').popover();

}
