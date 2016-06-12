
requirejs.config({
  paths: {
    "jquery": "jquery-1.11.1"
   // ,"_": "fun"
    
  }
  ,shim: {
    'fun':{
      deps: ['jquery'],
　　　exports: 'fun',
      init: function (fun) {
        return {aa:aa,bb:bb}; 
      }
    }
  }
});

require(['jquery','fun'], function ($,_){
  $(function(){
     _.aa();
     $("#btn1").click(function(){_.bb();});
     // _.bb();
     //window._=_;
  });
});


/*
$(function(){
      aa();
      bb();
});
*/