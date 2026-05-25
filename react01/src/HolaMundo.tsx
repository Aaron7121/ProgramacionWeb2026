function HolaMundo(props: {name:string}) {
    const handleClick = () =>
    {
        alert('click componente' + props.name);
    }
    return (
        <>
            <h4>Hola mundo! {props.name}</h4>
            <b>Ejemplo de componente REACT!</b>
            <button onClick={handleClick}>Click</button>
        </>
    )
}

export default HolaMundo;