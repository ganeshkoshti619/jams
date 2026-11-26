
import { useEffect, useState } from 'react'
import { getCompany } from '../services/companyService'
import '../App.css'

function Dashboard() {

  const [company, setCompany] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    getCompany()
      .then(data => setCompany(data))
      .catch(error => setError(error.message))
      .finally(() => setLoading(false))
  }, [])

  return (
    <div className="app-container">

      <aside className="sidebar">
        <h2 className="logo">JAMS</h2>
        <p className="logo-subtitle">Recruitment Management</p>

        <nav>
          <a href="#" className="active">Dashboard</a>
          <a href="#">Departments</a>
          <a href="#">Employees</a>
          <a href="#">Job Openings</a>
          <a href="#">Candidates</a>
          <a href="#">Applications</a>
          <a href="#">Interviews</a>
          <a href="#">Company Settings</a>
        </nav>
      </aside>

      <main className="main-content">
        <header className="top-header">
          <h3>Admin Dashboard</h3>
          <div className="admin-profile">
            {loading ? 'Loading...' : company?.companyName || 'Administrator'}
          </div>
        </header>

        <section className="dashboard-content">
          <h1>Welcome to JAMS</h1>
          <p>
            Manage your company's recruitment activities
            from one place.
          </p>

          {error && <p>{error}</p>}
        </section>
      </main>

    </div>
  )
}

export default Dashboard
