package com.base.data.models;

public class User
{
  private String name;
  private String password;
  private boolean isAdmin;

  /*
  * @pre: String representing userName, password, and a boolean to determine admin status
  * @post: assign local variables to passed in values
  * @return: none
   */
  public User (
  String name,
  String password,
  boolean isAdmin)
  {
    this.name = name;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the username
   */
  public String getName()
  {
    return name;
  }

  /*
  * @pre: A valid string
  * @post: re-assigns the member variable username
  * @return: none
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the password
   */
  public String getPassword()
  {
    return password;
  }

  /*
  * @pre: A valid string
  * @post: re-assigns the member variable password
  * @return: none
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the isAdmin value
   */
  public boolean getAdmin()
  {
    return isAdmin;
  }

  /*
  * @pre: A valid boolean
  * @post: re-assigns the member variable isAdmin
  * @return: none
   */
  public void setAdmin(boolean isAdmin)
  {
    this.isAdmin = isAdmin;
  }
}
