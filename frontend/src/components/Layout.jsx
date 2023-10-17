import { Outlet } from "react-router-dom"
import { NavBarExport } from "./Navbar"

const Layout = () => {
    return (
        <main className="App">
            <NavBarExport />
            <Outlet />
        </main>
    )
}

export default Layout
