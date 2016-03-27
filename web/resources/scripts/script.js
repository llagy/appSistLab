/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function seleccionar(elemento) {
            //alert(elemento);
    var combo = document.forms['inputForm'].countries;
             var cantidad = combo.length;
             
             for (i = 0; i < cantidad; i++) {
             if (combo[i].value == elemento) {
               combo[i].selected = true;
             }  
           combo[0].selected = true;
       }
   
    }
    
    
    function valueCodProf() {
     var valor = document.getElementById("idFormProf:codigo").value;       
    
        alert(valor);
            
           return valor;
      
   
    }
    
    
    