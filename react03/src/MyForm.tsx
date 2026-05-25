import {useState} from "react";
import * as React from "react";

function MyForm(){



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


    return (

        <>
        <form onSubmit={handleClick} method="GET">
            <div className="form-group">

                Nombre:<input type="text" value={name} onChange={handleChange}/>
            </div>
            <h1  ></h1>


                    <input type="submit" value = "Enviar1" />
                     <input type="submit" value = "Enviar2" />
                    <input type="button" value = "button" />


        </form>



        </>

    )


}
export default MyForm