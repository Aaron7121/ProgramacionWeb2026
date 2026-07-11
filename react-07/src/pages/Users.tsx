import {useEffect, useState} from "react";
import type {User} from "../models/User.tsx";
import axios from "axios";
import {Container, Typography} from "@mui/material";
import Table from "@mui/material/Table";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import TableCell from "@mui/material/TableCell";
import TableBody from "@mui/material/TableBody";
import Button from "@mui/material/Button";
import {Link} from "react-router-dom";

function Users(){

    const [user, setUser] = useState<User[]>([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        axios.get<User[]>('http://localhost:8080/api/users')
            .then(response => setUser(response.data))
            .catch(error => alert("Error: " + error))
            .finally(() => setLoading(false));

    }, []);
    return(
        <>
            <Container sx={{mt:4}}>
                <Typography variant="h4">
                    Usuarios en mi app
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
                            <TableCell>Name</TableCell>
                            <TableCell>Email</TableCell>
                            <TableCell>Acción</TableCell>

                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {
                            user.map(user => (
                                <TableRow key={user.id}>
                                    <TableCell>{user.id}</TableCell>
                                    <TableCell>{user.name}</TableCell>
                                    <TableCell>{user.email}</TableCell>
                                    <TableCell>
                                        <Button color={"secondary"} variant={"outlined"} component={Link} to={`/users/${user.id}`}>
                                        Ver Detalle
                                        </Button>
                                    </TableCell>
                                    <TableCell>
                                        <Button color={"secondary"} variant={"outlined"} component={Link} to={`/users/${user.id}/posts`}>
                                            Posts
                                        </Button>
                                    </TableCell>
                                    <TableCell>
                                        <Button color={"secondary"} variant={"outlined"} component={Link} to={`/users/${user.id}/todos`}>
                                            To Do
                                        </Button>
                                    </TableCell>
                                    <TableCell>
                                        <Button color={"secondary"} variant={"outlined"} component={Link} to={`/users/${user.id}/albums`}>
                                            Album
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
export default Users;