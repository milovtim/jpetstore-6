PetShop demo
=================

PetShop is a web application built on top of MyBatis 3, Spring 3 and Angular5.



## Run on Application Server
Running JPetStore sample under Tomcat (using the [cargo-maven2-plugin](https://codehaus-cargo.github.io/cargo/Maven2+plugin.html)).

- Clone this repository

  ```
  $ git clone https://github.com/milovtim/jpetstore-6.git
  ```

- Build war file

  ```
  $ cd jpetstore-6
  $ ./mvnw clean package
  ```

- Startup the Tomcat server and deploy web application

  ```
  $ ./mvnw cargo:run -P tomcat90
  ```

  > Note:
  >
  > We provide maven profiles per application server as follow:
  >
  > | Profile    | Description |
  > | ---------- | ----------- |
  > | tomcat85   | Running under the Tomcat 8.5 |
  > | tomcat80   | Running under the Tomcat 8.0 |
  > | tomcat70   | Running under the Tomcat 7.0 |

