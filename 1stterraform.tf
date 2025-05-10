provider "aws" {
  region = "us-east-1"
}
resource "aws_instance" "web" {
  ami           = "ami-0f88e80871fd81e91"
  instance_type = "t2.micro"
  key_name = "id_rsa"

  tags = {
    Name = "HelloWorld"
  }
}