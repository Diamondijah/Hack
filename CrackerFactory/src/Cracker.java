class Cracker{
    String rightPassword ;
    String foundPassword ;


    public Cracker(String rightPassword,String foundPassword)
    {
    this.rightPassword = rightPassword ;
    this.foundPassword = foundPassword ;
    
     } 


    public String getRightPassword(){
        return this.rightPassword ;
    }

    public String getFoundPassword(){
        return this.foundPassword ;
    }

    public void setRightPassword(String p){
        this.rightPassword = p;
    }

     public void setFoundPassword(String p){
        this.foundPassword = p;
    }

    public Cracker(){
        
    }
}