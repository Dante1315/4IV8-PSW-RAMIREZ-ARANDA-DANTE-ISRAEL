function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which
    if(teclado==8)return true;

    var patron= /[0-9\d .]/

    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba)
}
 function he(){
    var s=document.formulario.cal1.value;
    var h=document.formulario.cal2.value;
    var st=parseInt(s);
    var ht=parseInt(h);
    if(ht>40 && ht<48){
        var sf=(ht-40)*(st+st)+40*st;
    }
    if(ht==40 || ht<40){
        var sf=ht*st;
    }       
    if(ht>48){
        var sp=8*(st+st)+40*st;
        var s3=(ht-48)*(st+st+st);
        var sf=sp+s3;

    }
    document.formulario.calti.value = "$"+sf;


 }

function borrar(){
    document.formulario.cal1.value = "";
    document.formulario.cal2.value = "";
    document.formulario.calti.value = "";
}