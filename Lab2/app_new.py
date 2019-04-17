"""

	Mantas Svedas Info 3gr. Role-Permission web service
	
	Resources: Users, UserByMail, Index

"""

from flask import Flask, request, g
from flask_restful import Resource, Api, reqparse
import os, json
import markdown
import shelve
import requests

app = Flask(__name__)
api = Api(app)

class AllUsers(Resource):
	###############
	def get(self):	
		url = 'http://friendservice/users'
		r = requests.get(url)
		reJSON = r.json()
		print(reJSON)
		return reJSON, 200 
		
class Users(Resource):
	###############
	def get(self):	
		shelf = get_db()
		keys = list(shelf.keys())

		users = []
		for key in keys:
			if key != "filled":
				users.append(shelf[key])
			
		if len(users) == 0:
			return {'message': "Not found, no clients", 'data': []}, 404
		return {'message': 'OK', 'data': users}, 200       
		
	###############
	def post(self):
		parser = reqparse.RequestParser()
		shelf = get_db()
		
		parser.add_argument('email', required=True)
		parser.add_argument('role', required=True)
		parser.add_argument('accessLevel', required=True)
		
		# Parse arguments into obj
		args = parser.parse_args()
		if args['email'] in shelf:
			return {'message': 'Conflict, Email Already Exists', 'data': {}}, 409
		
		# Request another service
		userEmail = args.email
		url = 'http://friendservice/users/' + userEmail
		response = requests.get(url)
		rData = response.json()
		if rData['message'] == "User not found":
			return {'message': 'Not Found, no such user', 'data': []}, 404
			
		#print(rData['message'])
		#return {'message': 'Debug', 'data': rData}, 200
		
		shelf[args['email']] = args
		args.update({'user': rData['data']})
		return {'message': 'Created', 'data': args}, 201, {'Location': '/users/' + args['email']}
		
	###############
	def delete(self):
		return {'message': "Not Allowed", 'data': []}, 405
		
	###############
	def put(self):
		return {'message': "Not Allowed", 'data': []}, 405
	
	

class UserByEmail(Resource):
	###############
	def get(self, email):
		shelf = get_db()		
		#Checks for user
		if not (email in shelf):
			return {'message': "Not Found, no such user", 'data': []},404
			
		#Returns user info
		args = shelf[email]		
		# Request another service
		userEmail = email
		url = 'http://friendservice/users/' + userEmail
		response = requests.get(url)
		rData = response.json()
		if rData['message'] == "User not found":
			return {'message': 'Not Found, no such user', 'data': []}, 404
		args.update({'user': rData['data']})
		
		return {'message': "OK", 'data': args}, 200		
	
	###############
	def post(self):
		return {'message': "Not Allowed", 'data': []}, 405


	###############	
	def put(self,email):
		parser = reqparse.RequestParser()
		shelf = get_db()
		
		#parser.add_argument('email', required=True)
		parser.add_argument('role', required=True)
		parser.add_argument('accessLevel', required=True)
		
		#Checks for user
		args = parser.parse_args()
		args.update({'email': email})
		if not (email in shelf):
			return {'message': "Not Found, no such user", 'data': []},404		
		
		# Request another service
		userEmail = args.email
		url = 'http://friendservice/users/' + userEmail
		response = requests.get(url)
		rData = response.json()
		if rData['message'] == "User not found":
			return {'message': 'Not Found, no such user', 'data': []}, 404
		
		#Edits client
		shelf[email] = args
		args.update({'user': rData['data']})
		return {'message': "OK, Edited", 'data': args}, 200
		
	###############	
	def delete(self, email):
		shelf = get_db()		
		#Checks for user
		if not (email in shelf):
			return {'message': "Not Found, no such user", 'data': []},404	
		
		#Deletes user
		del shelf[email]		
		return {'message': "No content", 'data': []}, 204
		
		
@app.route('/')
#class Index(Resource):
def get():
	shelf = get_db()
	if "filled" not in shelf:
		print("First")
		fill()	
		shelf["filled"] = 1
	"""Present some documentation"""
	#Opens the README file
	with open('README_new.md', 'r') as markdown_file:
		# Read file and convert it to HTML
		content = markdown_file.read()
		return markdown.markdown(content)
	
	
################################		
#api.add_resource(Index, '/')
api.add_resource(AllUsers, '/users_all')
api.add_resource(Users, '/users')
api.add_resource(UserByEmail, '/users/<string:email>')

def fill():
	shelf = get_db()
	url = 'http://friendservice/users'
	data = {"email": "hax@gmail.com",
			"role": "Manager",
			"accessLevel": "One"}
	r = requests.post(url, data=data)
	shelf["hax@gmail.com"] = data
	#print(r.text)
	
	data = {"email": "musk@gmail.com",
			"role": "Admin",
			"accessLevel": "Three"}
	r = requests.post(url, data=data)
	shelf["musk@gmail.com"] = data
	#print(r.text)
	return

def get_db():
    db = getattr(g, '_database', None)
    if db is None:
        db = g._database = shelve.open("shelf_User-Role.db")
    return db


@app.teardown_appcontext
def teardown_db(exception):
    db = getattr(g, '_database', None)
    if db is not None:
        db.close()


if __name__ == '__main__':
	app.run(host="0.0.0.0", port="5001", debug=True)
	#app.run(host="localhost", debug=True)
	
"""
	# Request to another service
	url = "url"
	
	headers = {'Content-type': 'application/json; charset=UTF-8'}
	
	data = {'key':'value'}
	
	params = {'key1': 'value1', 'key2': 'value2'}
	
	response = requests.get(url, data=data, headers=headers, params=payload)
	rJON = response.json()
"""
	
