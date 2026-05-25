import { useState } from "react";

// 1. El Contrato (Props)
interface MedidorCafe {
    nombreUsuario: string;
    limiteDiario: number;
}

function MedidorCafe({ nombreUsuario, limiteDiario }: MedidorCafe) {
    // 2. El Motor (Hooks)
    // TS infiere que 'tazas' es un number.
    const [tazas, setTazas] = useState(0);

    const beberCafe = () => {
        if (tazas < limiteDiario) {
            setTazas(tazas + 1);
        }
    };

    const alLimite = tazas === limiteDiario;

    return (

        <>
            <h3>Panel de {nombreUsuario}</h3>
            <p>Tazas consumidas: {tazas} / {limiteDiario}</p>

            <button onClick={beberCafe} disabled={alLimite}>
                {alLimite ? "¡Demasiada cafeína! 🛑" : "Beber un café ☕"}
            </button>
        </>
    );
}

export default MedidorCafe;
// CÓMO SE USA EN OTRO ARCHIVO:
// <MedidorCafe nombreUsuario="Ana" limiteDiario={3} />