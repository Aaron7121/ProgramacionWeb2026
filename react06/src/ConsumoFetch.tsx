import {useState} from "react";


interface Post{
    id:number;
    title:string;
    body:string;


}
function ConsumoFetch(){

 const [postId,setPostId]= useState('1')

    const [post,setPost]=useState <Post|null>(null)
    const [loading,setLoading]= useState(false)
    const handleClick=() =>{
    setLoading(true)
    fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`,{
     method:'GET',
     headers:{
         'Content-Type': 'application/json'
     }
 }).then(response => response.json())
     //.then(data => alert(data.body))}
        .then(data=> {
            setPost(data);
            console.log(loading)

    })
        .finally(() => setLoading(false))
 }
    return(
        <>
        <h2> Fetch </h2>
            Id:<input type="text" placeholder="id"
            value={postId}
            onChange={e=>setPostId(e.target.value)}
        />
            <button onClick={handleClick}>Consultar</button>
            {loading && <p>Cargando......</p>}
            <div>  {postId}</div>
            {
            post &&
            (<div>
            <p>ID: {post.id}</p>
                <p>Title: {post.title}</p>
                <p>Bdy: {post.body}</p>

            </div>)
            }


        </>



    )

}
export default ConsumoFetch