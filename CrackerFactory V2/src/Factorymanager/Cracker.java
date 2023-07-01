class Cracker{
    String username ;
    String foundPassword ;


    public Cracker(String username,String foundPassword)
    {
    this.username = username ;
    this.foundPassword = foundPassword ;
    
     } 


    public String getusername(){
        return this.username ;
    }

    public String getFoundPassword(){
        return this.foundPassword ;
    }

    public void setusername(String p){
        this.username = p;
    }

     public void setFoundPassword(String p){
        this.foundPassword = p;
    }

    public Cracker(){
        
    }
}