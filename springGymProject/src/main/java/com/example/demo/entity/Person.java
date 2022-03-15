package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Person {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@Column(unique = true, nullable = false)
			private String name;
			
			@Column
			private int benchPressKG;
			
			
			@Column
			private int shoulderPressKG;
			
			@Column
			private int bicepCurlKG;
			
			@Column
			private int squatKG;
			
			public Person() {}

			public Person(String name, int benchPressKG, 
					int shoulderPressKG, int bicepCurlKG, 
					int squatKG) {
				super();
				this.name = name;
				this.benchPressKG = benchPressKG;
				this.shoulderPressKG = shoulderPressKG;
				this.bicepCurlKG = bicepCurlKG;
				this.squatKG = squatKG;
				
			}
			
			public Person(long id, String name, int benchPressKG, 
					int shoulderPressKG, int bicepCurlKG, 
					int squatKG) {
				super();
				this.id = id;
				this.name = name;
				this.benchPressKG = benchPressKG;
				this.shoulderPressKG = shoulderPressKG;
				this.bicepCurlKG = bicepCurlKG;
				this.squatKG = squatKG;
			}

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getBenchPressKG() {
				return benchPressKG;
			}

			public void setBenchPressKG(int benchPressKG) {
				this.benchPressKG = benchPressKG;
			}


			public int getShoulderPressKG() {
				return shoulderPressKG;
			}

			public void setShoulderPressKG(int shoulderPressKG) {
				this.shoulderPressKG = shoulderPressKG;
			}

			public int getBicepCurlKG() {
				return bicepCurlKG;
			}

			public void setBicepCurlKG(int bicepCurlKG) {
				this.bicepCurlKG = bicepCurlKG;
			}

			public int getSquatKG() {
				return squatKG;
			}

			public void setSquatKG(int squatKG) {
				this.squatKG = squatKG;
			}

		
			

			@Override
			public String toString() {
				return "Person [Id=" + id + ", Name=" + name + ", BenchPressKG="
						+ benchPressKG + ", ShoulderPressKG=" + shoulderPressKG + ", "
						+ "bicepCurlKG=" + bicepCurlKG
						+ "," + "SquatKG=" + squatKG + "]";
			}

			@Override
			public int hashCode() {
				return Objects.hash(benchPressKG, bicepCurlKG, name, 
						shoulderPressKG, squatKG);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Person other = (Person) obj;
				return benchPressKG == other.benchPressKG 
						&& bicepCurlKG == other.bicepCurlKG
						&& Objects.equals(name, other.name) 
						&& shoulderPressKG == other.shoulderPressKG
						&& squatKG == other.squatKG;
			}

			
			
}
			
	
			
			

