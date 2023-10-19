import { Outlet } from "react-router-dom"
import { NavBarExport } from "./Navbar"
import Footer from "./Footer"

const Layout = () => {
    return (
        <main className="App">
            <NavBarExport />
            <Outlet />
            <Footer />
        </main>
    )
}

export default Layout
