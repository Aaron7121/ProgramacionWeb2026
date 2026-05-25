import { Link, Route, Routes } from 'react-router-dom'
import './App.css'
import CasaInteligente from './Interruptor'
import MedidorCafe from './MedidorCafe';
import BuscadorPersonajes from './Ejercicio3';


function App() {

  return (
    <>


        <nav>

            <Link to="/medidorCafe">MedidorCafe</Link>

            <br/>
            <br/>
            <Link to="/interruptor">Interruptor</Link>
            <br/>
            <Link to= "/buscador">BuscadorPersonajes</Link>

            <br/>

        </nav>
        <Routes>


            <Route path="/medidorCafe" element={<MedidorCafe nombreUsuario={"HOLA MUNDO"} limiteDiario={4}/>}/>
            <Route path="/interruptor" element={<CasaInteligente/>}/>
            <Route path="/buscador" element={<BuscadorPersonajes/>}/>


            </Routes>


    </>
  )
}

export default App;