import API_BASE_URL from './api'

export const getCompany = async () => {
    const response = await fetch(`${API_BASE_URL}/api/company`)

    if (!response.ok) {
        throw new Error('Failed to fetch company details')
    }

    return response.json()
}