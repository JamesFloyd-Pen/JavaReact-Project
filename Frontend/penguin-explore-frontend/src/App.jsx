import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)
  const [backendMessage, setBackendMessage] = useState('Loading...')
  const [backendStatus, setBackendStatus] = useState('Checking...')
  const [backendBobby, setBackendBobby] = useState('Checking...')


  useEffect(() => {
    // Test connection to backend
    fetch('http://localhost:8080/api/hello')
      .then(response => response.text())
      .then(data => setBackendMessage(data))
      .catch(error => setBackendMessage('Error: ' + error.message))

    fetch('http://localhost:8080/api/status')
      .then(response => response.text())
      .then(data => setBackendStatus(data))
      .catch(error => setBackendStatus('Error: ' + error.message))

    fetch('http://localhost:8080/api/bobby')
      .then(response => response.text())
      .then(data => setBackendBobby(data))
      .catch(error => setBackendBobby('Error: ' + error.message))
  }, [])

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      
      <div className="card">
        <h2>Backend Connection Test</h2>
        <p><strong>Hello Endpoint:</strong> {backendMessage}</p>
        <p><strong>Status Endpoint:</strong> {backendStatus}</p>
        <p><strong>Bobby:</strong> {backendBobby}</p>

      </div>

      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
