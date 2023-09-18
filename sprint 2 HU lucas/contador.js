document.querySelector("#btn-sumar").addEventListener("click", sumarUno);
        document.querySelector("#btn-restar").addEventListener("click", restarUno);
        let contador=0;
        function sumarUno(){
            contador= contador+1;
            document.querySelector("#msgContador").innerHTML=contador;
        }
        function restarUno(){
            contador= contador-1;
            document.querySelector("#msgContador").innerHTML=contador;
        }