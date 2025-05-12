terraform {
  backend "s3" {
    bucket = "batch-b9"
    region = "us-east-1"
  }
}

provider "aws" {
  region = "us-east-1"
}
resource "aws_instance" "web" {
  ami           = "ami-0f88e80871fd81e91"
  instance_type = "t2.micro"
  key_name = "id_rsa"
  vpc_security_group_ids = ["sg-0d34c3d2b6fa6492a"]

  tags = {
    Name = "HelloWorld"
  }
}