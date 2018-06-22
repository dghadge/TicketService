#!/bin/bash

export AWS_DEFAULT_REGION=us-east-2

aws cloudformation create-stack --stack-name ticketservice-vpc --template-body file://vpc-and-subnets.json --parameters file://vpc-and-subnets-parameters.json --capabilities CAPABILITY_IAM --profile labs

aws cloudformation wait stack-create-complete --stack-name ticketservice-vpc --profile labs

aws cloudformation create-stack --stack-name ticketservice-eb --template-body file://elasticbeanstalk.json --parameters file://elasticbeanstalk-parameters.json --capabilities CAPABILITY_IAM --profile labs