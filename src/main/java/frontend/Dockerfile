FROM node:lts-alpine

# make the 'app' folder the current working directory
WORKDIR /app

# copy both 'package.json' and 'package-lock.json' (if available)
#COPY ./src/frontend/package*.json ./

# install project dependencies
#RUN npm install

# copy project files and folders to the current working directory (i.e. 'app' folder)
#COPY src/main/java/frontend/ .

# build app for production with minification
CMD [ "npm", "run", "serve" ]