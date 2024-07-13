
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danstestapp.data.JobResponse
import com.danstestapp.databinding.JobsItemBinding
import com.danstestapp.utils.DateTimeUtils
import com.danstestapp.view.activity.JobDetailActivity


class JobAdapter(private var jobList: List<JobResponse>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    private var filteredJobList: List<JobResponse> = jobList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = JobsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = filteredJobList[position]
        holder.bind(job)
    }

    override fun getItemCount(): Int = filteredJobList.size

    fun filter(query: String) {
        filteredJobList = if (query.isEmpty()) {
            jobList
        } else {
            jobList.filter {
                it.title.contains(query, ignoreCase = true) ||
                        it.company.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    fun updateData(newData: List<JobResponse>) {
        jobList = newData
        filter("") // Reset filter to show all items
    }

    inner class JobViewHolder(private val binding: JobsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: JobResponse) {
            binding.apply {
                companyTextView.text = job.company
                locationTextView.text = job.location
                titleTextView.text = job.title
                timeAgoTextView.text = DateTimeUtils().convertToRelativeTime(job.createdAt)
                applicantsTextView.text = "${job.company} Applicants"

                root.setOnClickListener {
                    val intent = Intent(it.context, JobDetailActivity::class.java).apply {
                        putExtra("jobId", job.id)
                    }
                    it.context.startActivity(intent)
                }
                }
//                jobTitle.text = job.title
//                companyName.text = job.company
//                jobLocation.text = job.location
//

        }
    }
}