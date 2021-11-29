package template;

public class Customer implements Comparable<Customer>{	
		private final int id;
		private String name;
		private String city;
		private String email;

		public Customer(int id, String name, String city, String email) {
			this.id = id;
			this.name = name;
			this.city = city;
			this.email = email;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public int getId() {
			return id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", city=" + city + "]";
		}

		
		@Override
		public int compareTo(Customer arg0) {
			return this.getName().compareTo(arg0.getName());
		}
	}

