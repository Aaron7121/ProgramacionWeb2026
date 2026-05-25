import { useState, useEffect } from 'react';

// Tipamos cómo se ve nuestro dato
interface Personaje {
    id: number;
    nombre: string;
    rol: string;
}

const BASE_DATOS: Personaje[] = [
    { id: 1, nombre: 'Luke Skywalker', rol: 'Jedi' },
    { id: 2, nombre: 'Darth Vader', rol: 'Sith' },
    { id: 3, nombre: 'Han Solo', rol: 'Contrabandista' },
];

function BuscadorPersonajes () {
    const [busqueda, setBusqueda] = useState<string>('');
    const [resultados, setResultados] = useState<Personaje[]>(BASE_DATOS);

    // useEffect se ejecuta cada vez que 'busqueda' cambia
    useEffect(() => {
        // Si la búsqueda está vacía, mostramos todos
        if (busqueda.trim() === '') {
            setResultados(BASE_DATOS);
            return;
        }

        // Filtramos la base de datos simulando una búsqueda
        const filtrados = BASE_DATOS.filter(personaje =>
            personaje.nombre.toLowerCase().includes(busqueda.toLowerCase())
        );
        setResultados(filtrados);

    }, [busqueda]); // Este array le dice a React: "Solo vigila la variable busqueda"

    return (
        <div>
            <h2>Buscador Galáctico</h2>
            <input
                type="text"
                placeholder="Buscar personaje..."
                value={busqueda}
                onChange={(e) => setBusqueda(e.target.value)}
                // onChange actualiza el estado, lo que dispara el useEffect
            />

            <ul>
                {resultados.map(personaje => (
                    <li key={personaje.id}>
                        <strong>{personaje.nombre}</strong> - {personaje.rol}
                    </li>
                ))}
            </ul>
            {resultados.length === 0 && <p>No se encontraron resultados.</p>}
        </div>
    );
};
export default BuscadorPersonajes;