import { useParams, Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

import {
    Box,
    CardContent,
    TextField,
    Typography,
    Button,
    Card,
    CardActions,
    Divider
} from "@mui/material";

import type { User } from "../models/User";

function UserDetalle() {

    const url = "https://jsonplaceholder.typicode.com/users";
    const { id } = useParams<{ id: string }>();

    const [user, setUser] = useState<User | null>(null);

    useEffect(() => {
        axios.get<User>(`${url}/${id}`)
            .then(response => setUser(response.data))
            .catch(error => alert("Error: " + error));
    }, [id]);

    const handleGuardar = () => {

        if (!user) return;

        axios.put<User>(`${url}/${id}`, user)
            .then(response => {
                setUser(response.data);
                alert("Usuario actualizado");
            })
            .catch(error => alert("Error: " + error));
    };

    if (!user) {
        return <div>Cargando...</div>;
    }

    return (
        <Box sx={{ maxWidth: 700, margin: "20px auto", px: 2 }}>

            <Card variant="outlined" sx={{ borderRadius: 3 }}>

                <CardContent sx={{
                    display: "flex",
                    flexDirection: "column",
                    gap: 2
                }}>

                    <Box
                        sx={{
                            display: "flex",
                            justifyContent: "space-between",
                            alignItems: "center"
                        }}
                    >
                        <Typography
                            variant="h5"
                            sx={{ fontWeight: "bold" }}
                        >
                            Editar Usuario
                        </Typography>

                        <Typography
                            variant="caption"
                            color="text.secondary"
                        >
                            ID: {user.id}
                        </Typography>
                    </Box>

                    <Divider />

                    {/* DATOS PERSONALES */}

                    <Typography variant="h6">
                        Datos Personales
                    </Typography>

                    <TextField
                        label="Nombre"
                        value={user.name}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                name: e.target.value
                            })
                        }
                    />

                    <TextField
                        label="Username"
                        value={user.username}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                username: e.target.value
                            })
                        }
                    />

                    <TextField
                        label="Email"
                        value={user.email}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                email: e.target.value
                            })
                        }
                    />

                    <TextField
                        label="Phone"
                        value={user.phone}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                phone: e.target.value
                            })
                        }
                    />

                    <TextField
                        label="Website"
                        value={user.website}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                website: e.target.value
                            })
                        }
                    />

                    <Divider />

                    {/* ADDRESS */}

                    <Typography variant="h6">
                        Dirección
                    </Typography>

                    <TextField
                        label="Street"
                        value={user.address.street}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                address: {
                                    ...user.address,
                                    street: e.target.value
                                }
                            })
                        }
                    />

                    <TextField
                        label="Suite"
                        value={user.address.suite}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                address: {
                                    ...user.address,
                                    suite: e.target.value
                                }
                            })
                        }
                    />

                    <TextField
                        label="City"
                        value={user.address.city}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                address: {
                                    ...user.address,
                                    city: e.target.value
                                }
                            })
                        }
                    />

                    <TextField
                        label="Zipcode"
                        value={user.address.zipcode}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                address: {
                                    ...user.address,
                                    zipcode: e.target.value
                                }
                            })
                        }
                    />

                    <Divider />

                    {/* COMPANY */}

                    <Typography variant="h6">
                        Empresa
                    </Typography>

                    <TextField
                        label="Company Name"
                        value={user.company.name}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                company: {
                                    ...user.company,
                                    name: e.target.value
                                }
                            })
                        }
                    />

                    <TextField
                        label="Catch Phrase"
                        value={user.company.catchPhrase}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                company: {
                                    ...user.company,
                                    catchPhrase: e.target.value
                                }
                            })
                        }
                    />

                    <TextField
                        label="BS"
                        value={user.company.bs}
                        fullWidth
                        onChange={(e) =>
                            setUser({
                                ...user,
                                company: {
                                    ...user.company,
                                    bs: e.target.value
                                }
                            })
                        }
                    />

                </CardContent>

                <CardActions
                    sx={{
                        justifyContent: "flex-end",
                        px: 4,
                        pb: 4,
                        gap: 2
                    }}
                >

                    <Button
                        variant="contained"
                        onClick={handleGuardar}
                    >
                        Guardar
                    </Button>

                    <Button
                        variant="outlined"
                        component={Link}
                        to="/users"
                    >
                        Regresar
                    </Button>

                </CardActions>

            </Card>

        </Box>
    );
}

export default UserDetalle;