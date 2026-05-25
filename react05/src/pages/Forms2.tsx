import { useLocation, useNavigate } from "react-router-dom";

function Forms2() {

    const navigate = useNavigate();
    const location = useLocation();
    const handleBack = () => {
        navigate("/");
    }



    const state = location.state as { message: string } | null;

    return (
        <form>
            <h2>Formulario 2</h2>

            {
                state && state.message? (
                    <p>
                        Nombre recibido: {state.message}
                    </p>
                ) : (
                    <p>No se recibió ningún nombre!!!!</p>
                )
            }

            <button type="button" onClick={handleBack}>
                Regresar
            </button>
        </form>
    )
}

export default Forms2;