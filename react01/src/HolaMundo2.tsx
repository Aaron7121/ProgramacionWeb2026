
export interface Hello2Props{
    name:string,
    age?:number
}

function HolaMundo(props: Hello2Props) {
    //function HolaMundo({name, age}: Hello2Props) {

   return (
       <>
       <h4>Hola mundo {props.name}</h4>
           {props.age && <h4>Edad {props.age}</h4>}

       </>
   )
}

export default HolaMundo;