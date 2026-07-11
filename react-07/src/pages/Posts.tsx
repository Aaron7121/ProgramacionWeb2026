import { Container, Typography } from "@mui/material";
import { useState } from "react";
import Button from '@mui/material/Button';
import axios from "axios";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import type {Post} from "../models/Post.ts";
import { Link } from "react-router-dom";
import { useEffect } from "react";

function Posts(){

    const [posts, setPosts] = useState<Post[]>([]);
    const [loading, setLoading] = useState(false);

    /* const fetchPosts = async () => {
         setLoading(true);
         axios.get<Post[]>('https://jsonplaceholder.typicode.com/posts')
         .then(response => setPosts(response.data))
         .catch(error => alert("Error: " + error))
         .finally(() => setLoading(false));
     }
     */

    useEffect(() => {
        axios.get<Post[]>('https://localhost:8080/api/posts')
            .then(response => setPosts(response.data))
            .catch(error => alert("Error: " + error))
            .finally(() => setLoading(false));

    }, []);


    return(
        <>
            <Container sx={{mt:4}}>
                <Typography variant="h4">
                    Posts
                </Typography>

                {/* <Button variant="contained"
                    color="primary"
                    onClick={fetchPosts}
                >
                    {loading ? "Cargando..." : "Cargar Datos"}
                </Button> */}

                <Table sx={{mt:2}}>
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>Title</TableCell>
                            <TableCell>Body</TableCell>
                            <TableCell>Acción</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {
                            posts.map(post => (
                                <TableRow key={post.id}>
                                    <TableCell>{post.id}</TableCell>
                                    <TableCell>{post.title}</TableCell>
                                    <TableCell>{post.body}</TableCell>
                                    <TableCell><Button color={"secondary"} variant={"outlined"} component={Link} to={`/posts/${post.id}`}>
                                        Ver Detalle
                                    </Button>
                                    </TableCell>
                                </TableRow>
                            ))
                        }
                    </TableBody>
                </Table>
            </Container>
        </>
    )
}

export default Posts;