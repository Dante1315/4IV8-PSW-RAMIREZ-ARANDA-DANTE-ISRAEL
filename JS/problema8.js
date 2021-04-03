function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which
    if(teclado==8)return true;

    var patron= /[0-9\d .]/

    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba)
}

function numeromm(){
    var p1=document.formulario.n1.value;
    var p2=document.formulario.n2.value;
    var p3=document.formulario.n3.value;
    var np=parseInt(p1);
    var ns=parseInt(p2);
    var nt=parseInt(p3);
    if(np>ns && np>nt){
        var s=np;
        document.formulario.numerom.value = s;
    }
    if(ns>np && ns>nt){
        var s=ns;
        document.formulario.numerom.value = s;
    }
    if(nt>ns && nt>np){
        var s=nt;
        document.formulario.numerom.value = s;
    }
    if(np==ns && np==nt){
        var ig=np;
        document.formulario.numerom.value = ig;
    }
    if(np==ns && np>nt){
        var ig=np;
        document.formulario.numerom.value = ig;
    }
}


function borrar(){
    document.formulario.n1.value = "";
    document.formulario.n2.value = "";
    document.formulario.n3.value = "";
    document.formulario.numerom.value = "";
}