import {useEffect, useState} from "react";


export default Contador;

function Contador(){
    const [contador, setContador] = useState(0);


   useEffect(()=> {
       console.log("Componente montado");
   })

    useEffect(()=>{
        console.log(`Contador cambiado ${contador}`);
    }, [contador]);

    const handleDown = () => {
        setContador(contador - 1)
    }


    const handleUp = () => {
        setContador(contador + 1)
    }
    return (


        <>
        <div>
            Valor {contador}
        </div>
            <br/>
            <button onClick={handleUp}>+</button>
            <button onClick={handleDown}>-</button>
            <br/>

        </>
    )


}

