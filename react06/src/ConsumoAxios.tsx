import axios from "axios";
import {useState} from "react";

interface Post{
    id:number;
    title:string;
    body:string;


}
function ConsumoAxios(){

    const [loading,setLoading]= useState(false)

    const[posts,setPosts] = useState<Post[]>([])


    const handleClick =()=>{
            setLoading(true)

            axios.get<Post[]>("https://jsonplaceholder.typicode.com/posts")
                .then(response=>{setPosts(response.data)})
                .catch(e=> alert(e))
                .finally(()=>setLoading(false))

        }
    return(

        <>
            <h2>AXIOS</h2>
            <button onClick={handleClick} > Busqueda</button>
            {loading && <p>Cargando.......</p>}


            <table style={{width:"100%"}}>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Body</th>

                </tr>




                </thead>
                <tbody>
                {
                    posts.map((post)=>

                        <tr key={post.id}>
                            <td> {post.id}</td>
                            <td> {post.title}</td>
                            <td> {post.body}</td>


                        </tr>

                    )

                }

                </tbody>


            </table>

        </>
    )

}

export default ConsumoAxios