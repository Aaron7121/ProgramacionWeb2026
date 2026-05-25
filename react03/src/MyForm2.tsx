import {useState} from "react";
import * as React from "react";

function MyForm2(){



    const handleSummit= (e: React.ChangeEvent<HTMLInputElement>) => {
        alert(`Texto ingresado '${name}'`)

    }

    const [name,setName] = useState("");

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {

        setName(e.target.value);

    }
    const handleClick= () =>{
        //avitamos que se envie al servidor , que es el compotamiento por defecto de mi imput en el form
        event.preventDefault()
        alert("submit");

    } //aqui comparamos un submit con un button

        function buscar(formData:FormData){
        const nombre=formData.get("nombre");
        const edad=formData.get("edad");
        alert(` Nombre "${nombre}" Edad "${edad}" `);

        }
    return (

        <>
            <form action={buscar}>
                <div className="form-group">

                    Nombre:<input type="text" name="nombre"/>
                    <br/>
                    Edad: <input type="text" name="edad"/>
                </div>
                <h1  ></h1>


                <input type="submit" value = "Enviar1" />


            </form>



        </>

    )


}
export default MyForm2