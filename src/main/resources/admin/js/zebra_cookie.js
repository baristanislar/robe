!function(a){"use strict";var b=function(){this.destroy=function(a){return this.write(a,"",-1)},this.read=function(a){var b=new RegExp("(^|; )"+encodeURIComponent(a)+"=(.*?)($|;)"),c=document.cookie.match(b);return c?decodeURIComponent(c[2]):null},this.write=function(a,b,c,d,e,f){var g=new Date;return c&&"number"==typeof c?g.setTime(g.getTime()+1e3*c):c=null,document.cookie=encodeURIComponent(a)+"="+encodeURIComponent(b)+(c?"; expires="+g.toGMTString():"")+"; path="+(d?d:"/")+(e?"; domain="+e:"")+(f?"; secure":"")}};a.cookie=new b}(jQuery);