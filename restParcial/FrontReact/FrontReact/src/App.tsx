import { BrowserRouter, Routes, Route } from "react-router-dom";
import Test from "./Test.tsx";
import {Typography} from "@mui/material";
import NavBar from "./components/NavBar.tsx";
import Clientes from "./pages/Cientes.tsx";

function Home() {
    return <h1>Home</h1>;
}

function App() {
    return (


<BrowserRouter>
    <NavBar/>


            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/test" element={<Test />} />
                <Route path="/clientes" element={<Clientes />} />
            </Routes>

</BrowserRouter>

    );
}

export default App;