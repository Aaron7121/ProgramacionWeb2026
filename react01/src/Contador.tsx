import {useState} from "react";
import HolaMundo2 from "./HolaMundo2.tsx";

export default Contador;

function Contador(){
    const handleUp = () => {
        setContador(contador *10000000000);

    }

    const handleDown = () => {
        setContador(contador - 1)
    }

    const [contador, setContador] = useState(0);

    return (


        <>
        <div>
            Valor {contador}
        </div>
            <br/>
            <button onClick={handleUp}>+</button>
            <button onClick={handleDown}>-</button>
            <br/>
            <HolaMundo2 name= "Juan" age={contador}/>
        </>
    )


}

