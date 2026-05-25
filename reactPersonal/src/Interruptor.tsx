import { useState } from 'react';

// --- COMPONENTE HIJO ---
interface InterruptorProps {
    habitacion: string;
    estaEncendido: boolean;
    // Así tipamos una función que recibe el nombre de la habitación y no devuelve nada
    alAlternar: (habitacion: string) => void;
}

function Interruptor ({ habitacion, estaEncendido, alAlternar }: InterruptorProps)  {
    return (
        <div style={{ margin: '10px 0' }}>
            <span>{habitacion}: {estaEncendido ? '💡 Encendida' : '🌑 Apagada'} </span>
            <button onClick={() => alAlternar(habitacion)}>
                {estaEncendido ? 'Apagar' : 'Encender'}
            </button>
        </div>
    );
};

// --- COMPONENTE PADRE ---
export const CasaInteligente = () => {
    // Estado complejo: un objeto que guarda el estado de cada habitación
    const [luces, setLuces] = useState({
        sala: true,
        cocina: false,
        dormitorio: false
    });

    // Esta función es la que pasaremos como Prop
    const alternarLuz = (habitacion: string) => {
        setLuces(estadoAnterior => ({
            ...estadoAnterior, // Copiamos el estado anterior
            // [habitacion]: !estadoAnterior[habitacion] // <- En TS estricto esto requiere tipos avanzados.
            // Por simplicidad, usemos una validación rápida:
            ...(habitacion === 'sala' && { sala: !estadoAnterior.sala }),
            ...(habitacion === 'cocina' && { cocina: !estadoAnterior.cocina }),
            ...(habitacion === 'dormitorio' && { dormitorio: !estadoAnterior.dormitorio }),
        }));
    };

    return (
        <div>
            <h2>Control Central del Hogar</h2>
            <Interruptor habitacion="sala" estaEncendido={luces.sala} alAlternar={alternarLuz} />
            <Interruptor habitacion="cocina" estaEncendido={luces.cocina} alAlternar={alternarLuz} />
            <Interruptor habitacion="dormitorio" estaEncendido={luces.dormitorio} alAlternar={alternarLuz} />
        </div>
    );
};

export default CasaInteligente;