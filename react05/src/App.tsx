import './App.css'
import { Route, Routes } from "react-router-dom";
import Forms1 from "./pages/Forms1.tsx";
import Forms2 from "./pages/Forms2.tsx";

function App() {
    return (
        <Routes>
            <Route path="/" element={<Forms1/>} />
            <Route path="/forms2" element={<Forms2/>} />
        </Routes>
    )
}

export default App