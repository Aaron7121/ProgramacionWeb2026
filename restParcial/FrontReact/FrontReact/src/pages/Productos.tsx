import {useEffect, useState} from "react";
import type {Producto} from "../model/Producto.ts";
import axios from "axios";

function Productos (){

    const[producto, setProducto]= useState<Producto[]>([])

    useEffect(() => {
        axios.get('http://localhost:9090/api/productos')
            .then(response => setProducto(response.data))
            .catch(e=> alert(e))
    }, []);

return(

    <>



    </>

)
}export default Productos