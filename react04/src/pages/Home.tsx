import { useState } from "react";

function Home() {
    const [text, setText] = useState("");
    const [duplicated, setDuplicated] = useState("");

    return (

        <>
            <h1>Home</h1>
            <h2>{duplicated}</h2>
            <div className="form-group">

                Ingrese algun texto:
                <input
                    type="text"
                    name="text"
                    value={text}
                    onChange={(e) => {
                        const v = e.target.value;
                        setText(v);
                        setDuplicated(v );
                    }}
                />

            </div>
        </>
    );
}

export default Home;
