const useAuthToken = () => {
    const [token, setToken] = useState<string>('');
  
    useEffect(() => {
      const authToken = localStorage.getItem('token');
      if (authToken) {
        setToken(authToken);
      }
    }, []);
  
    return token;
  };

  export default useAuthToken;