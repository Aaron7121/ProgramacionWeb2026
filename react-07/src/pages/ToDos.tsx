import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";

import type { ToDo } from "../models/ToDo";

import {
    Container,
    Typography,
    Card,
    CardContent,
    Button,
    Box,
    Chip
} from "@mui/material";

function ToDos() {

    const { id } = useParams<{ id: string }>();

    const [todos, setTodos] = useState<ToDo[]>([]);

    useEffect(() => {

        axios
            .get<ToDo[]>(
                `https://jsonplaceholder.typicode.com/todos?userId=${id}`
            )
            .then(response => setTodos(response.data))
            .catch(error => alert("Error: " + error));

    }, [id]);

    return (

        <Container sx={{ mt: 4 }}>

            <Box
                sx={{
                    display: "flex",
                    justifyContent: "space-between",
                    alignItems: "center",
                    mb: 3
                }}
            >

                <Typography variant="h4">
                    ToDos del Usuario {id}
                </Typography>

                <Button
                    variant="outlined"
                    component={Link}
                    to="/users"
                >
                    Regresar
                </Button>

            </Box>

            {
                todos.map(todo => (

                    <Card
                        key={todo.id}
                        sx={{ mb: 2 }}
                    >

                        <CardContent>

                            <Typography
                                variant="h6"
                                sx={{
                                    textDecoration:
                                        todo.completed
                                            ? "line-through"
                                            : "none"
                                }}
                            >
                                {todo.title}
                            </Typography>

                            <Chip
                                label={
                                    todo.completed
                                        ? "Completado"
                                        : "Pendiente"
                                }
                                color={
                                    todo.completed
                                        ? "success"
                                        : "warning"
                                }
                                sx={{ mt: 1 }}
                            />

                            <Box sx={{ mt: 2 }}>

                                <Button
                                    variant="outlined"
                                    component={Link}
                                    to={`/todos/${todo.id}`}
                                >
                                    Ver Detalle
                                </Button>

                            </Box>

                        </CardContent>

                    </Card>
                ))
            }

        </Container>
    );
}

export default ToDos;