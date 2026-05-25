import {useState} from "react";
import {useNavigate} from "react-router-dom";

function Forms1() {

    const [name, setName] = useState("")

    const navigate = useNavigate();
    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()
        navigate("/forms2",{state:{message: name}})
    }
    return (
        <form onSubmit={handleSubmit}>
            <h2>Formulario 1</h2>

            Nombre:
            <input
                type="text"
                   value={name}
                   onChange={(e) => setName(e.target.value)} />

            <input type = "submit" value="Enviar" />
        </form>
    )
}

export default Forms1;