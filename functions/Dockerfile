# Gunakan image Node.js sebagai base image
FROM node:18

# Set working directory
WORKDIR /usr/src/appt 

# Copy package.json dan package-lock.json ke dalam container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy seluruh proyek ke dalam container
COPY . .

# Expose port aplikasi (sesuaikan dengan port yang digunakan server Anda)
EXPOSE 3000

# Set environment variable untuk PORT (opsional, namun berguna untuk debugging)
ENV PORT=3000

# Perintah untuk menjalankan aplikasi
CMD ["node", "server.js"]
