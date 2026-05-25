import './App.css'
import * as React from "react";
import HolaMundo from "./HolaMundo.tsx";
import HolaMundo2, {type Hello2Props} from "./HolaMundo2.tsx";
import Contador from "./Contador.tsx";

function App() {

  const [number, setNumber] = React.useState(1);

  const handleClick = () => {
    setNumber(prev => prev + 1);
  };

  const props: Hello2Props = {
      name : "otro nombre",
      age : 77
  };
  return (
      <div>
        Hola <span>{number}</span>
        <br/>
        <button onClick={handleClick}>Click</button>
        <HolaMundo name = "Juan"/>
        <HolaMundo name = "Pedro"/>

        <br/>
        <HolaMundo2 name= "Juan"/>
          <HolaMundo2 name= "Pedro"/>

          <hr/>
          <HolaMundo2 name= "Marco" age ={20}/>
          <HolaMundo2 {...props}/>
          <HolaMundo2 name={props.name} age={props.age}/>
          <hr/>
          <Contador/>
      </div>
  );
}

export default App;